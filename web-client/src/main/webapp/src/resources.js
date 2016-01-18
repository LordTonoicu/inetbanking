/**
 * 
 */
var resources = angular.module('iNetBanking.resources', ['ngResource']);

resources.factory('UserResource', function($resource) {
	
	return $resource('http://localhost:8080/web-api/users/:id/:method', {id: '@id',method: '@method'});
});
