(function(){
    var emailApp = angular.module('emailApp',[
       // 'ngRoute', //
        'email.service',
        'email.controller'
    ]);

    /*emailApp.config(['$routeProvider', function($routeProvider){
        $routeProvider.when('/',{
            controller: 'EmailController',
            templateUrl: 'resources/applications/mail/views/upload-emails.html'
        });
    }]);*/


})();