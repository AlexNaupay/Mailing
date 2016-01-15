(function(){
    angular.module('service.business',[])
        .factory('businessService',['$http', '$q',function($http, $q){

            /**
             * get all business
             * @returns {d.promise|*|promise}
             */
            var business = function(){
                var deferred = $q.defer();  // Object defer

                // make request
                $http.get('/mailing/business')
                    .success(function(data){  // if request success
                        deferred.resolve(data);  // resolve promise
                        console.log('Success', data);
                    })
                    .error(function(data){  // if request error
                        deferred.reject(data);  // reject promise
                        console.log('Error', data);
                    });

                return deferred.promise;  // return the promise
            };
            
            function getBusiness(id){
            	var deferred = $q.defer();
            	$http.get('/mailing/business/'+id)
            	.success(function(data){
            		deferred.resolve(data);
            	});
            	
            	return deferred.promise;
            }




            return {
                all : business,
                getBusiness: getBusiness
            };


        }])
    ;
})();