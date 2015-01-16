var myApp = angular.module('app', []);

myApp.controller('MainCtrl', function ($scope, $http, $http) {

    $scope.currencyList = currencyList;
    $scope.periodYearList = periodYearList;

    console.log($scope.periodYearList);


    $scope.send = function () {

        var url = '/currencyExchange/' + $scope.currency + "/" + $scope.period;
        console.log(url);

        $http({
            'method': 'GET',
            'url': url,
            'headers': "Content-Type:application/json"
        }).success(function (data, status) {
            console.log(data);
            $scope.result = data.value;
        })
        .error(function (data, status) {
                console.log("failed");
        });
    }

    $scope.refreshValues = function () {

        var url = '/currencyExchange/refresh/' +  $scope.period;
        console.log(url);

        $http({
            'method': 'GET',
            'url': url,
            'headers': "Content-Type:application/json"
        }).success(function (data, status) {
            console.log(data);
            $scope.result = data.value;
        })
            .error(function (data, status) {
                console.log("failed");
            });
    }


});