$(function() {
  console.log('ready!');
});

angular.module('ngFormReset', [])
  .controller('FormResetController', function($scope) {
	 
    'use strict';
    $scope.one = false; 
    
    $scope.pkgForm = function() {
    	
        if ($scope.pkgForm.$valid) {
        	$scope.one = true; 
            $('#reset-pkg').show()
            $('#showpkg').show()
        }
      }
      $scope.resetpkg = function() {
      	
        $scope.formData = {};
        $scope.pkgForm.$setPristine();
        $scope.one = false; 
        $('#showpkg').hide()
        $('#reset-pkg').hide()
      }
    
    
      $scope.submitForm = function() {
      	
          if ($scope.myForm.$valid) {
              $('#reset-btn').show()
              $('#show').show()
          }
        }
        $scope.reset = function() {
        	
          $scope.formData = {};
          $scope.myForm.$setPristine();
          $('#show').hide()
          $('#reset-btn').hide()
        }
        
    
    
  });


