/**
 * 
 */

function StatelessCRUDResourceRepository($scope,resource) {
	$scope.getAllElements = function() {
		return resource.query();
	}
	$scope.save = function(entity, callback) {
		var rToSave = new resource();
		angular.extend(rToSave,entity);
		rToSave.$save(function(data){
			callback(data);
		});
	}
}