/*(function () {
    'use strict';

    angular
        .module('loginapp')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService'];
    function LoginController($location, AuthenticationService, FlashService) {
        var vm = this;

        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
                if (response.success) {
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    $location.path('/');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    };*/
    
    app.service("LoginService", function ($scope, $http, $q, $state, $location) {
        this.Login = function (sub) {
            var encodeString = { userame: sub.userame, password: sub.password };
            consloe(encodeString);
            $http({
    			method: "POST",
    			url: "http://localhost:8484/pma/stage",
    			data: encodeString,
    			headers: {'Accept':' text/plain', 'Content-Type': "application/x-www-form-urlencoded"}
    		}).success(function (response) {  });
        }
    });

    app.controller('login', function ($scope, LoginService, $window) {
    	alert("11111111111111111111111");
    	$scope.login = function () {
            var sub = {
                userame: $scope.username,
                password: $scope.password
            };
            alert(sub);
            $scope.login = function(){
        		var encodeString = "username=" + this.username + "&password=" + this.password;
            
            
            var checkData = LoginService.Login(sub);
            checkData.then(function (data) {
                //want redirection        
                  $window.location.href = '/Home/index.html';
                }, function (error) {
                })
            };
    }
    });





/*angular.module('loginapp',[]) // ... omitted code
.controller("loginCtl",['$scope','$http','$location', function($scope, $http, $location){
	$scope.login = function(){
		var encodeString = "username=" + this.username + "&password=" + this.password;
		$http({
			method: "POST",
			url: "http://localhost:8484/pma/stage",
			data: encodeString,
			headers: {'Accept':' text/plain', 'Content-Type': "application/x-www-form-urlencoded"}
		}).success(function(data, status, headers, config){
			$location.path("/home.html");
			console.log(data);
			$scope.msg=data;
			$scope.curdate=new Date();
		}).error(function(data, status, headers, config){
			console.log(data);
			console.log(status);
			console.log(headers);
			console.log(config);
			console.log("Error submit form");
		});
	}
}]);

*/


/*


.controller('loginCtl',
  function($rootScope, $scope, $http, $location) {
  var authenticate = function(callback) {
    $http.get('user').success(function(data) {
      if (data.name) {
        $rootScope.authenticated = true;
      } else {
        $rootScope.authenticated = false;
      }
      callback && callback();
    }).error(function() {
      $rootScope.authenticated = false;
      callback && callback();
    });
  }
  authenticate();
  $scope.credentials = {};
  
  $scope.login = function() {
    $http.post('login', $.param($scope.credentials), {
      headers : {
        "content-type" : "application/x-www-form-urlencoded"
      }
    }).success(function(data) {
      authenticate(function() {
        if ($rootScope.authenticated) {
          $location.path("/");
          $scope.error = false;
        } else {
          $location.path("/login");
          $scope.error = true;
        }
      });
    }).error(function(data) {
      $location.path("/login");
      $scope.error = true;
      $rootScope.authenticated = false;
    })
  };
});*/