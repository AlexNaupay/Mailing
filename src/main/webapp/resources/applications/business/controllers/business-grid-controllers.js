(function(){
    angular.module('controller.businessgrid',[])
        .controller('BusinessGridController',['$scope','businessService',function($scope,businessService){
            $scope.business = [];

            businessService.all().then(function(data){
                console.log('in controller: ',data);
                $scope.business = data.data;
            });
        }])

    ;
})();