(function(){
    angular.module('controller.business',[])
        .controller('BusinessController',['$scope', '$rootScope', '$routeParams', 'business',
         function($scope, $rootScope, $routeParams,business){

            $scope.bus = business.data;
                       

        }]);
})();