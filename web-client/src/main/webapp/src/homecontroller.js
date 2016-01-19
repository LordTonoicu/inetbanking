/**
 * 
 */

function HomeController($location,$scope,$rootScope,AccountResource,HistoryResource) {
	$scope.accounts = AccountResource.query({method:'user',criteria: $rootScope.user.id});
	$scope.histories = HistoryResource.query({method:'user',criteria: $rootScope.user.id});
}