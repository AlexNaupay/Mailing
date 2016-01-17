(function(){
    angular.module('service.business',[])
        .factory('businessService',['$http', '$q',function($http, $q){
        	var base_url = '/mailing/';
            /**
             * get all business
             * @returns {d.promise|*|promise}
             */
            var business = function(){
                var deferred = $q.defer();  // Object defer

                // make request
                $http.get(base_url+'business')
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


            /**
             * get business by id
             * @param id
             * @returns {d.promise|*|promise}
             */
            function getBusiness(id){
            	var deferred = $q.defer();
            	$http.get(base_url+'business/'+id)
            	.success(function(data){
            		deferred.resolve(data);
            	});
            	
            	return deferred.promise;
            }

            function save(business){
                var deferred = $q.defer();
                $http.post(base_url+'/business',business)
                    .success(function(data){
                        deferred.resolve(data);
                    });

                return deferred.promise;
            }

            function update(business){
                var deferred = $q.defer();
                $http.put(base_url+'business',business)
                    .success(function(data){
                        deferred.resolve(data);
                    });

                return deferred.promise;
            }

            function remove(id_business){
                var deferred = $q.defer();
                $http.delete(base_url+'business/'+id_business)
                    .success(function(data){
                        deferred.resolve(data);
                    });

                return deferred.promise;
            }




            return {
                all : business,
                getBusiness: getBusiness,
                save: save,
                update: update,
                remove: remove
            };


        }])
    ;
})();