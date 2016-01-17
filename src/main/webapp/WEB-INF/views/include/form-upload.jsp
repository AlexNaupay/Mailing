
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" data-ng-controller="EmailController">

	<div class="bs-callout bs-callout-warning" id="callout-formgroup-inputgroup"> 
		<h3>Subir Emails</h3> 
	</div>
	
    <div class="col-md-4">
    
        <div class="form-group">
	        <label for="company-select">Compañia</label>
	        <select id="company-select" class="form-control" ng-model="companySelect" ng-change="change()">
	            <option value="0" selected="selected">ninguno</option>
	            <option ng-repeat="company in allCompanies" value="{{company.id}}">{{company.name}}</option>
	        </select>
        </div>
        

		<div class="form-group">
		      <label for="business-select">Rubro</label>
		      <select  id="business-select" class="form-control" ng-model="businessSelect" ng-change="change()"
		      	 data-ng-options="business.name for business in allBusiness track by business.id">
		      </select>
		</div>
        
        <p class="alert alert-warning" ng-show="companySelect && businessSelect"><strong>{{countEmail}}</strong> emails con esta combinación</p>
        
        <div class="form-group">
		    <label for="file">Archivo de emails</label>
		    <input type="file" id="file" ngf-select="onFileSelect($files)">
		    <p class="help-block">Elija un archivo *.txt o *.cvs</p>
	  </div>
	  
	  
	  
       <div class="col-sm-10">
           <button data-ng-click="sendMail()" class="btn btn-success" data-ng-disabled="form_register_business.$invalid">
           	Subir Archivo
           </button>
       </div>
        

    </div>


    <div class="col-md-8" ng-show="file">
    	<p>
    		<i class="glyphicon glyphicon-file"></i>
    		{{fileName}}
    	</p>
    	<p>
    		<i class="glyphicon glyphicon-hdd"></i>
    		{{fileSize}}
    	</p>
    	
		<div class="progress">
		  <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="{{percentProgress}}" aria-valuemin="0" aria-valuemax="100" style="width: {{percentProgress}}%">
		    	<span class="sr-only">{{percentProgress}}% Complete</span>
		  </div>
		</div>
		
		<div class="alert alert-info" role="alert">
			Se subieron {{ numberEmailsProcess }} emails corectamente
		</div>
		
    </div>

</div>