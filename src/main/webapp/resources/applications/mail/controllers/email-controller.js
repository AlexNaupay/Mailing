(function(){
    angular.module('email.controller',['ngFileUpload'])
        .controller('EmailController',['$scope' ,'emailService','Upload', function($scope, emailService, Upload){
            $scope.companySelect = 0;
            $scope.businessSelect = 0;

            $scope.countEmail = 0;

            $scope.allCompanies = [];
            $scope.allBusiness = [];

            emailService.allCompanies().then(function(data){
                $scope.allCompanies = data.data;
            });

            emailService.allBusiness().then(function(data){
                $scope.allBusiness = data.data;
            });

            $scope.change = function(){
            	//debugger;
                if($scope.companySelect!=0 && $scope.businessSelect!=0)
                    emailService.countEmails($scope.companySelect, $scope.businessSelect).then(function(data){
                       $scope.countEmail = data.data;
                    });
            };

            $scope.onFilesSelect = function(files){
            	// files is a array of the files
            	
            };
            
            $scope.onFileSelect = function(files){
            	if(files != null){
            		$scope.file = files[0];
                    
                    $scope.fileName = $scope.file.name;  // file?
                    $scope.fileSize = ($scope.file.size/(1024)).toFixed(2)+'kB';
            	}
            	
            };
            
            $scope.sendMail = function(){
            	$scope.file.upload = Upload.upload({
            		url: '/mailing/emails',
            		method: 'POST',
            		fields: { file: $scope.file, companyId: $scope.companySelect, businessId: $scope.businessSelect.id}
            	});
            	
            	$scope.file.upload.then(function(response){
            		$scope.numberEmailsProcess = response.data.data;
            		//console.info(response);
            	}, function(error){
            		debugger;
            	}, function(evt){
            		debugger;
            		$scope.percentProgress = parseInt(Math.min(100, parseInt(100.0 * evt.loaded / evt.total)));
            	});
            	
            };
            

        }]);
})();