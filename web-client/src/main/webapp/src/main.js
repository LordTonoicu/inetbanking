/**
 * 
 */
angular.module('iNetBanking', ['ngRoute', 'ngCookies', 'iNetBanking.resources','datatables'])
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
				templateUrl: 'views/home.html',
				controller: HomeController
			});
			$routeProvider.when('/accounts', {
				templateUrl: 'views/accounts.html',
				controller: AccountController
			});
			$routeProvider.when('/', {
				templateUrl: 'views/home.html',
				controller: HomeController
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
			        		}  
			        		else if (status = 500) {
			        	        $rootScope.error = rejection.data;
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
	).run(function(DTOptionsBuilder,$rootScope, $location, $cookieStore) {
			
		/* Reset error when a new view is loaded */
		$rootScope.$on('$viewContentLoaded', function() {
			delete $rootScope.error;
		});
		$rootScope.dtOptions = DTOptionsBuilder.newOptions();
		$rootScope.userisType = function(type) {
			if($rootScope.user) {
				return $rootScope.user.type == type;
			}
			return false;
		}
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

		