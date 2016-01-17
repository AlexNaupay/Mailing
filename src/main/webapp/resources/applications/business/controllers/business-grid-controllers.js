(function(){
    angular.module('controller.businessgrid',[])
        .controller('BusinessGridController',['$scope','businessService','$location',
            function($scope, businessService, $location){
            $scope.business = [];

            businessService.all().then(function(data){
                console.log('in controller: ',data);
                $scope.business = data.data;
            });

            $scope.delete = function(id_business){
                businessService.remove(id_business).then(function(data){
                    console.log("Removed...", data);
                    $location.path('/');  // other option is delete item of the array (without to redirect)
                });
            }
        }])

    ;
})();