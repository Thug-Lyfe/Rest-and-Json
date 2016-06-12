'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngAnimate',
    'angular-jwt',
    'ui.bootstrap',
    'ngTable'
])
        .controller('myAppCtrl', function ($http, $scope, NgTableParams) {
            //ca-mb1337.rhcloud.com/SemesterSeed/api/Currency/getRates


            $scope.getTests = function () {
                if ($scope.Amount != null || $scope.props.length !== 0) {
                    $http({
                        method: "GET",
                        url: "api/addresses/" + $scope.Amount + "/" + $scope.Props
                    }).then(function (response) {

                        var data = response.data;
                        $scope.tableParams = new NgTableParams({page: 1, count: 10}, {dataset: data});
                    });
                }
            };
            $scope.getTestsLocal = function () {
                
                    $http({
                        method: "GET",
                        url: "http://exam-mb1337.rhcloud.com/Rest_and_Json/api/addresses/100/fname,lname,street,city?callback=myData"
                    }).then(function (response) {

                        var data = response.data;
                        $scope.tableParams = new NgTableParams({page: 1, count: 10}, {dataset: data});
                    });
                
            };

        })




