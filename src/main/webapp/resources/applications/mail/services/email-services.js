(function(){
    angular.module('email.service',[])
        .factory('emailService',['$http', '$q',function($http, $q){

            countEmails = function(company_id, business_id){
                var deferred = $q.defer();
                if (typeof(company_id) == "object")
                    company_id = company_id.id;
                if (typeof(business_id) == "object")
                    business_id = business_id.id;
                debugger;
                $http({
                    method: 'GET',
                    url: '/mailing/emails',
                    params : {company_id: parseInt(company_id), business_id: parseInt(business_id)}  // this key have to it call 'params' 
                }).success(function(data){
                    deferred.resolve(data);
                    console.info("Count in services ", data);
                });

                return deferred.promise;
            };

            allBusiness = function(){
                var deferred = $q.defer();
                $http.get('/mailing/business')
                    .success(function(data){  // if request success
                        deferred.resolve(data);  // resolve promise
                        //debugger;
                    });
                return deferred.promise;
            };

            allCompanies = function(){
                var deferred = $q.defer();
                $http.get('/mailing/companies')
                    .success(function(data){  // if request success
                        deferred.resolve(data);  // resolve promise
                        //debugger;
                    });
                return deferred.promise;
            };
            
            return {
            	countEmails: countEmails,
            	allBusiness: allBusiness,
            	allCompanies: allCompanies
            };
            
            

        }]);
})();