
var app = angular.module('app', ['ui.router']);

app.config(['$urlRouterProvider', '$stateProvider', function($urlRouterProvider, $stateProvider) {
	var globalvar=$rootScope.globelvar;
	
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
	
	.state('shadow.pma.pmaupdate', {
		url:'/shadow/pma/pmaupdate',
		templateUrl: 'pmaupdate.html',
		controller:'pma',
		params: {
			type: {
				value: 'pkgcode',
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
	
	
	.state('stage.pma.pmaupdate', {
		url:'/stage/pma/pmaupdate',
		templateUrl: 'pmaupdate.html',
		controller:'pma',
		params: {
			type: {
				value: 'pkgcode',
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
	
	.state('load.pma.pmaupdate', {
		url:'/load/pma/pmaupdate',
		templateUrl: 'pmaupdate.html',
		controller:'pma',
		params: {
			type: {
				value: 'pkgcode',
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
	
	.state('latest.pma.pmaupdate', {
		url:'/latest/pma/pmaupdate',
		templateUrl: 'pmaupdate.html',
		controller:'pma',
		params: {
			type: {
				value: 'pkgcode',
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
	
	
	.state('training.pma.pmaupdate', {
		url:'/training/pma/pmaupdate',
		templateUrl: 'pmaupdate.html',
		controller:'pma',
		params: {
			type: {
				value: 'pkgcode',
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
	
	.state('production.pma.pmaupdate', {
		url:'/production/pma/pmaupdate',
		templateUrl: 'pmaupdate.html',
		controller:'pma',
		params: {
			type: {
				value: 'pkgcode',
				squash: true
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

//controller PMA Login

app.controller("pma",['$stateParams','$scope','$http','$rootScope','$location', '$state' function($stateParams, $scope, $http, $q, $rootScope, $location, $state){
	$scope.login = function(){
		var encodeString = "username=" + this.username + "&password=" + this.password;
		alert(encodeString);
		$http({
			method: "POST",
			url: "/pma/"+$stateParams.type.toLowerCase(),
			data: encodeString,
			headers: {'Accept':' text/plain', 'Content-Type': "application/x-www-form-urlencoded"}
		}).success(function(data, status, headers, config){
			//$state.go('production.pma.pmaupdate');
			$location.url('/production/pma/pmaupdate');
			 $window.alert( 'helllllllllllllllllll' );
			
			$rootScope.globelvar=data;
			$location.path('pmaupdate.html');
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

/*
app.controller("pma",['$stateParams','$scope','$http', function($stateParams,$scope, $http, $q){
	$scope.login = function(){
		var encodeString = "username=" + this.username + "&password=" + this.password;
		var user=this.username;
		var pass=this.password;
		if(user.equalsEgnorcase('admin') && pass='admin')
	}
}]);
*/



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
