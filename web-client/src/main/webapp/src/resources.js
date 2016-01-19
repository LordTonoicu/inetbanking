/**
 * 
 */
var resources = angular.module('iNetBanking.resources', ['ngResource']);

resources.factory('UserResource', function($resource) {
	
	return $resource('http://localhost:8080/web-api/users/:id/:method/:name', {id: '@id',method: '@method', name:'@name'});
});
resources.factory('AccountResource', function($resource) {
	
	return $resource('http://localhost:8080/web-api/accounts/:id/:method/:criteria', {id: '@id',method: '@method', criteria:'@criteria'});
});
resources.factory('HistoryResource', function($resource) {
	
	return $resource('http://localhost:8080/web-api/history/:id/:method/:criteria', {id: '@id',method: '@method', criteria:'@criteria'});
});

