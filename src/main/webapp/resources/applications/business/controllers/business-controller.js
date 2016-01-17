(function(){
    angular.module('controller.business',[])
        .controller('BusinessController',['$scope', '$rootScope', '$routeParams', 'business',
            'businessService', '$location',
            function($scope, $rootScope, $routeParams,business, businessService, $location){
             $scope.bus = business.data;

             $scope.saveOrUpdate = function(){
                 var bus = angular.copy($scope.bus);
                 //debugger;
                 if(!bus.id){  // if id is not defined
                     $scope.save(bus);
                 }else{  // if id is defined
                     $scope.update(bus);
                 }
             };

             $scope.save = function(business){
                 businessService.save(business).then(function(data){
                     console.log("Saved...", data);
                     $location.path('/business');
                 });
             };

             $scope.update = function(business){
                 businessService.update(business).then(function(data){
                     console.log("Updated...", data);
                     $location.path('/');
                 });
             };



        }]);
})();