(function(){
	var app = angular.module('Mail',[
        'ngRoute',
        'ui.bootstrap',
        /* controllers modules */
        'controller.businessgrid',
        'controller.business',

        /* services modules */
        'service.business'
    ]);


    /* config routes */
    app.config(['$routeProvider',function($routeProvider){

        $routeProvider
            .when('/business',{
                controller: 'BusinessGridController',
                templateUrl: 'resources/applications/business/views/list-business.html'
            })
            .when('/business/:id_business',{
            	title: 'Manage Business',
                controller: 'BusinessController',
                templateUrl: 'resources/applications/business/views/register-business.html',
                resolve: {
                	business : ['businessService','$route','$q',function(businessService, $route, $q){
                        // return promise when it is resolve and inject into controller
                		var id_business = $route.current.params.id_business;

                		if (id_business != 0){
                			return businessService.getBusiness(id_business);
                		}else{
                			var data = {};
                			data['data'] = {
                					id: 0,
                					name: '',
                					description: '',
                					createdAt: null
                			};
                			return $q.when(data);
                		}
                		
                	}]
                }
            })
            .otherwise({redirectTo:'/business'});
    }]);


})();