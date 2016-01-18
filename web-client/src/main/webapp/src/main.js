/**
 * 
 */
angular.module('iNetBanking', ['ngRoute', 'ngCookies', 'iNetBanking.resources'])
	.config(
		[ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
				
			$routeProvider.when('/login', {
				templateUrl: 'views/login.html',
				controller: UserController
			});
			$routeProvider.when('/createaccount', {
				templateUrl: 'views/createaccount.html',
				controller: UserController
			});
			
			$routeProvider.when('/index', {
				templateUrl: 'views/home.html'
			});
			$routeProvider.when('/', {
				templateUrl: 'views/home.html'
			});
			$locationProvider.hashPrefix('!');
			/* Register error provider that shows message on failed requests or redirects to login page on
			 * unauthenticated requests */
		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
			        return {
			        	'responseError': function(rejection) {
			        		var status = rejection.status;
			        		var config = rejection.config;
			        		var method = config.method;
			        		var url = config.url;
			      
			        		if (status == 401) {
			        			$location.path( "/login" );
			        		} else {
			        			$rootScope.error = method + " on " + url + " failed with status " + status;
			        		}
			        		return $q.reject(rejection);
			        	}
			        };
			    }
		    );
		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
		        return {
		        	'request': function(config) {
		        		var isRestCall = config.url.indexOf('web-api') == 0;
		        		if (isRestCall && angular.isDefined($rootScope.authToken)) {
		        			var authToken = $rootScope.authToken;
		        			config.headers['X-Auth-Token'] = authToken;
		        		}
		        		return config || $q.when(config);
		        	}
		        };
		    }
		    );
			}
		]
	).run(function($rootScope, $location, $cookieStore) {
			
		/* Reset error when a new view is loaded */
		$rootScope.$on('$viewContentLoaded', function() {
			delete $rootScope.error;
		});
		
		$rootScope.goToLoginPage = function() {
			$location.path("login");
		}
		$rootScope.logout = function() {
			delete $rootScope.user;
			delete $rootScope.authToken;
			$cookieStore.remove('authToken');
			$location.path("/login");
		};
		
		 /* Try getting valid user from cookie or go to login page */
		var originalPath = $location.path();
		$location.path("/login");
		var authToken = $cookieStore.get('authToken');
		if (authToken !== undefined) {
			$rootScope.authToken = authToken;
			UserService.get(function(user) {
				$rootScope.user = user;
				$location.path(originalPath);
			});
		}
		
		$rootScope.initialized = true;
	});

		