
var app = angular.module('app', ['ui.router']);

app.config(['$urlRouterProvider', '$stateProvider', function($urlRouterProvider, $stateProvider) {

	$urlRouterProvider.otherwise('/');

	$stateProvider
	.state('home', {
		url:'/',
		templateUrl: 'home.html'
	})
	
	
	.state('shadow', {
		url:'/shadow',
		templateUrl: 'commonHTML.html',
		controller:'commonHTML',
		params: {
			type: {
				value: 'Shadow',
				squash: true
			}
		}
	})
	.state('shadow.getAllPackages', {
		url:'/shadow/getAllPackages',
		templateUrl: 'SuccessProject.html',
		controller:'successProject',
		params: {
			type: {
				value: 'shadow',
				squash: true
			}
		}

	})
	.state('shadow.getRejectedPackages', {
		url:'/shadow/getRejectedPackages',
		templateUrl: 'FailedProjects.html',
		controller:'failedProjects',
		params: {
			type: {
				value: 'shadow',
				squash: true
			}
		}
	})
	.state('shadow.pma', {
		url:'/shadow/pma',
		templateUrl: 'PMA.html',
		controller:'pma',
		params: {
			type: {
				value: 'shadow',
				squash: true
			}
		}
	})
	.state('stage', {
		url:'/stage',
		templateUrl: 'commonHTML.html',
		controller:'commonHTML',
		params: {
			type: {
				value: 'Stage',
				squash: true
			}
		}
	})
	.state('stage.getAllPackages', {
		url:'/stage/getAllPackages',
		templateUrl: 'SuccessProject.html',
		controller:'successProject',
		params: {
			type: {
				value: 'stage',
				squash: true
			}
		}
	})
	.state('stage.getRejectedPackages', {
		url:'/stage/getRejectedPackages',
		templateUrl: 'FailedProjects.html',
		controller:'failedProjects',
		params: {
			type: {
				value: 'stage',
				squash: true
			}
		}
	})
	.state('stage.pma', {
		url:'/stage/pma',
		templateUrl: 'PMA.html',
		controller:'pma',
		params: {
			type: {
				value: 'stage',
				squash: true
			}
		}
	})
	.state('load', {
		url:'/load',
		templateUrl: 'commonHTML.html',
		controller:'commonHTML',
		params: {
			type: {
				value: 'Load',
				squash: true
			}
		}
	})
	.state('load.getAllPackages', {
		url:'/load/getAllPackages',
		templateUrl: 'SuccessProject.html',
		controller:'successProject',
		params: {
			type: {
				value: 'load',
				squash: true
			}
		}
	})
	.state('load.getRejectedPackages', {
		url:'/load/getRejectedPackages',
		templateUrl: 'FailedProjects.html',
		controller:'failedProjects',
		params: {
			type: {
				value: 'load',
				squash: true
			}
		}
	})
	.state('load.pma', {
		url:'/load/pma',
		templateUrl: 'PMA.html',
		controller:'pma',
		params: {
			type: {
				value: 'load',
				squash: true
			}
		}
	})
	.state('latest', {
		url:'/latest',
		templateUrl: 'commonHTML.html',
		controller:'commonHTML',
		params: {
			type: {
				value: 'Latest',
				squash: true
			}
		}
	})
	.state('latest.getAllPackages', {
		url:'/latest/getAllPackages',
		templateUrl: 'SuccessProject.html',
		controller:'successProject',
		params: {
			type: {
				value: 'latest',
				squash: true
			}
		}

	})
	.state('latest.getRejectedPackages', {
		url:'/latest/getRejectedPackages',
		templateUrl: 'FailedProjects.html',
		controller:'failedProjects',
		params: {
			type: {
				value: 'latest',
				squash: true
			}
		}
	})
	.state('latest.pma', {
		url:'/latest/pma',
		templateUrl: 'PMA.html',
		controller:'pma',
		params: {
			type: {
				value: 'latest',
				squash: true
			}
		}
	})

	.state('training', {
		url:'/training',
		templateUrl: 'commonHTML.html',
		controller:'commonHTML',
		params: {
			type: {
				value: 'Training',
				squash: true
			}
		}
	})
	.state('training.getAllPackages', {
		url:'/training/getAllPackages',
		templateUrl: 'SuccessProject.html',
		controller:'successProject',
		params: {
			type: {
				value: 'training',
				squash: true
			}
		}

	})
	.state('training.getRejectedPackages', {
		url:'/training/getRejectedPackages',
		templateUrl: 'FailedProjects.html',
		controller:'failedProjects',
		params: {
			type: {
				value: 'training',
				squash: true
			}
		}
	})
	.state('training.pma', {
		url:'/training/pma',
		templateUrl: 'PMA.html',
		controller:'pma',
		params: {
			type: {
				value: 'training',
				squash: true
			}
		}
	})
	.state('production', {
		url:'/production',
		templateUrl: 'commonHTML.html',
		controller:'commonHTML',
		params: {
			type: {
				value: 'Production',
				squash: true
			}
		}
	})
	.state('production.getAllPackages', {
		url:'/production/getAllPackages',
		templateUrl: 'SuccessProject.html',
		controller:'successProject',
		params: {
			type: {
				value: 'production',
				squash: true
			}
		}
	})
	.state('production.getRejectedPackages', {
		url:'/production/getRejectedPackages',
		templateUrl: 'FailedProjects.html',
		controller:'failedProjects',
		params: {
			type: {
				value: 'production',
				squash: true
			}
		}
	})
	.state('production.pma', {
		
		url:'/production/pma',
		templateUrl: 'PMA.html',
		controller:'pma',
		params: {
			type: {
				value: 'production',
				squash: true
			}
		}
	})
	
	.state('load.pma.login', {
		url:'/load/pma/login',
		views:{
			"update":{
				templateUrl: 'pmaupdate.html',
				controller:'pmaupdate',
				params: {
					type: {
						value: 'load',
						squash: true
					}
				}
			}
		}
		
	})
	
	.state('stage.pma.login', {
		url:'/stage/pma/login',
		views:{
			"update":{
				templateUrl: 'pmaupdate.html',
				controller:'pmaupdate',
					params: {
						type: {
							value: 'stage',
							squash: true
						}
					}
			}
		}
		
	})
	.state('shadow.pma.login', {
		url:'/shadow/pma/login',
		views:{
			"update":{
				templateUrl: 'pmaupdate.html',
				controller:'pmaupdate',
				params: {
					type: {
						value: 'shadow',
						squash: true
					}
				}
			}
		}
		
	})
	
	.state('latest.pma.login', {
		url:'/latest/pma/login',
		views:{
			"update":{
				templateUrl: 'pmaupdate.html',
				controller:'pmaupdate',
				params: {
					type: {
						value: 'latest',
						squash: true
					}
				}
			}
		}
		
	})
	
	.state('training.pma.login', {
		url:'/training/pma/login',
		views:{
			"update":{
				templateUrl: 'pmaupdate.html',
				controller:'pmaupdate',
					params: {
						type: {
							value: 'training',
							squash: true
						}
					}
			}
		}
		
	})
	
	
	.state('production.pma.login', {
		url:'/production/pma/login',
		views:{
			"update":{
				templateUrl: 'pmaupdate.html',
				controller:'pmaupdate',
					params: {
						type: {
							value: 'production',
							squash: true
						}
					}
			}
		}
		
	})
	
	
		
	;
}]);

app.controller('successProject',['$stateParams','$scope','$http', function($stateParams,$scope, $http, $q){

	$scope:date=new Date();
console.log(date);
$scope.loading = true;
$http.get('/'+$stateParams.type.toLowerCase()+'/getPackageDetails')
.then(function (response){
	$scope.date=new Date();
	$scope.product = response.data; // For multiple row
	$scope.loading = false;
	console.log("status:" + response.status);
}).catch(function(response) {
	console.error('Error occurred:', response.status, response.data);
}).finally(function() {
	console.log("Task Finished.");
});
}]);

//Failure Production

app.controller('failedProjects',['$stateParams','$scope','$http', function($stateParams,$scope, $http, $q){

	$scope.loading = true;

	$http.get('/'+$stateParams.type.toLowerCase()+'/getRejectedPackages')
	.then(function (response){
		var test=Object.keys(response.data).length;
		if(Object.keys(response.data).length == 0){
			$scope.loading = false;
			$scope.msg=test;
		}else{
			$scope.product = response.data; // For multiple row
			$scope.loading = false;
			console.log("status:" + response.status);
			console.log($scope.response);
		}
	}).catch(function(response) {
		alert("Error");
		console.error('Error occurred:', response.status, response.data);
	}).finally(function() {
		console.log("Task Finished.");
	});
}]); 


//Loading Screen
app.directive('loading', function () {
	return {
		restrict: 'E',
		replace:true,
		template: '<div  class="loading"><img src="images/giphy.gif" width="70px" height="70px" /></div>',
		link: function (scope, element, attr) {
			scope.$watch('loading', function (val) {
				if (val)
					$(element).show();
				else
					$(element).hide();
			});
		}
	}
});



app.controller('commonHTML',['$stateParams','$scope','$http', function($stateParams,$scope, $http, $q){
	$scope.heading=$stateParams.type+" Environment";
	$scope.envType=$stateParams.type.toLowerCase();
	
}]); 

app.controller('updatepma',['$stateParams','$scope','$http', function($stateParams,$scope, $http, $q){
	$scope.heading=$stateParams.type+" Environment";
	$scope.envType=$stateParams.type.toLowerCase();
	
}]); 



app.controller('pma', function ($rootScope,$scope,$http, $window, $stateParams, $state, $location) {
	
	var msg;
	$scope.login = function(){
		var encodeString = "username=" + this.username + "&password=" + this.password;
		$http({
			method: "POST",
			url: "/pma/"+$stateParams.type.toLowerCase(),
			data: encodeString,
			headers: {'Accept':' text/plain', 'Content-Type': "application/x-www-form-urlencoded"}
		}).success(function(data, status, headers, config){
			//$state.transitionTo('pmaupdate');
			console.log(data);
			msg=$scope.data;
			
			var text2 = data.toLowerCase();
			if(text2 !=="authentication failed"){
				$scope.myVar=true;
				$scope.msg=data;
				//$location.path('/pmaupdate.html');
				$rootScope.preventNavigation();
				$state.go(data+'.pma.login');				
				
			}
			else{
				//$scope.updateVar=false;
				$scope.msg=data;
				$scope.curdate=new Date();
			}		
			//$window.location.href = '/pmaupdate.html'
			$scope.curdate=new Date();
		}).error(function(data, status, headers, config){
			console.log(data);
			console.log(status);
			console.log(headers);
			console.log(config);
			console.log("Error submit form");
		});
	};
      

});

app.controller('pmaupdate',['$stateParams','$scope','$http', function($stateParams,$scope, $http, $q){
       var msg;
          
	
	$scope.updatedata=function(){
		
		var pak1=$scope.pakdata;
		 var cnt1=$scope.contract;
		 var pma1=$scope.pmadata;
		 $scope.update1="";
		 $scope.update2="";
		 $scope.update3="";
		 var pkg_code="0";
		
		 pkg_code = $scope.pkgcode;
		 
		if(pkg_code && pak1){
			alert(pkg_code);
				$http({
				method: "POST",
				url: "/pma/"+$stateParams.type.toLowerCase()+'/packagecodeupdate?pkg_code='+pkg_code,
				data:null,
				headers: {'Accept':' text/plain', 'Content-Type': "application/x-www-form-urlencoded"}
			}).success(function(data, status, headers, config){
				//$state.transitionTo('pmaupdate');
				console.log(data);
				//alert(data);
				$scope.update1=data;
				$scope.curdate=new Date();
			}).error(function(data, status, headers, config){
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
				console.log("Error submit form");
			});	
			
			
		};
		
		if(cnt1){
			//alert(cnt1);
			$http({
				method: "POST",
				url: "/pma/"+$stateParams.type.toLowerCase()+'/contractupdate',
				data:null,
				headers: {'Accept':' text/plain', 'Content-Type': "application/x-www-form-urlencoded"}
			}).success(function(data, status, headers, config){
				//$state.transitionTo('pmaupdate');
				console.log(data);
				//alert(data);
				$scope.update2=data;
				$scope.curdate=new Date();
			}).error(function(data, status, headers, config){
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
				console.log("Error submit form");
			});	
			
			/*if ($scope.chForm.$valid) {
	            $('#reset-btn5').show()
	            $('#show5').show()
	            $scope.chForm.$setPristine();
	        }*/
		};
				
		if(pma1){
			//alert(pma11);
			$http({
				method: "POST",
				url: "/pma/"+$stateParams.type.toLowerCase()+'/pmaupdate',
				data:null,
				headers: {'Accept':' text/plain', 'Content-Type': "application/x-www-form-urlencoded"}
			}).success(function(data, status, headers, config){
				//$state.transitionTo('pmaupdate');
				console.log(data);
				//alert(data);
				$scope.update3=data;
				$scope.curdate=new Date();
			}).error(function(data, status, headers, config){
				console.log(data);
				console.log(status);
				console.log(headers);
				console.log(config);
				console.log("Error submit form");
			});	
			
			
		};
	};
	
	$scope.resettest = function() {
		  $scope.chForm={};
		};
}]); 



app.run(['$rootScope', '$location', function ($rootScope, $location) {

	  var _preventNavigation = false;
	  var _preventNavigationUrl = null;

	  $rootScope.allowNavigation = function() {
	    _preventNavigation = false;
	  };

	  $rootScope.preventNavigation = function() {
	    _preventNavigation = true;
	    _preventNavigationUrl = $location.absUrl();
	  }

	  $rootScope.$on('$locationChangeStart', function (event, newUrl, oldUrl) {
	    // Allow navigation if our old url wasn't where we prevented navigation from
	    if (_preventNavigationUrl != oldUrl || _preventNavigationUrl == null) {
	      $rootScope.allowNavigation();
	      return;
	    }

	    if (_preventNavigation) {
	      event.preventDefault();
	    }
	    else {
	      $rootScope.allowNavigation();
	    }
	  });
	}]);

app.directive('activeLink', ['$location', function (location) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs, controller) {
          var clazz = attrs.activeLink;
          var path = attrs.href;
          path = path.substring(1); //hack because path does not return including hashbang
          scope.location = location;
          scope.$watch('location.path()', function (newPath) {
            if (path === newPath) {
              element.addClass(clazz);
            } else {
              element.removeClass(clazz);
            }
          });
        }
      };
    }]);
