/**
 * 
 */

function AccountController($rootScope,$scope,AccountResource) {
	angular.extend(this,new StatefullCRUDResourceRepository($scope,AccountResource));
}