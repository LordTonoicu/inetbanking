/**
 * 
 */

function UserController($location,$rootScope,$scope, UserResource) {
	angular.extend(this,StatelessCRUDResourceRepository($scope,UserResource));
	
	$scope.login = function(user) {
		var userR = new UserResource();
		angular.extend(userR,user);
		userR.$save({method:'authenticate'}, function(authToken){
			$rootScope.authToken = authToken;
			$rootScope.user = user;
			$location.path("/");
		});
	}
}