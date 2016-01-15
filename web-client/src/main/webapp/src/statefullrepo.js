/**
 * 
 */

function StatefullCRUDResourceRepository($scope, resource) {
	$scope.elementList = resource.query(function(){
		$scope.listLoaded = true;
	});
	$scope.selectElement = function(element) {
		$scope.selectedElement = new resource();
		angular.extend($scope.selectedElement,element);
	}
	$scope.saveSelectedElement = function() {
		$scope.selectedElementSaved = false;
		$scope.selectedElement.$save(function() {
			$scope.selectedElementSaved = true;
		});
	}
	$scope.deleteSelectedElement = function() {
		$scope.selectedElementDeleted = false;
		$scope.selectedElement.$delete(function(){
			//TODO: use grep to search by ID
			$scope.selectedElementDeleted = true;
			$scope.elementList.splice(1,$scope.elementList.indexOf($scope.selectedElement));
		});
	}
}