import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class SortProvider {

  constructor(public http: HttpClient) {
    console.log('Hello SortProvider Provider');
  }
  
  sortByString(data,field,order){
    if(order == 'ascending'){
      return data.sort(function(a, b) {
        var valueA = a[field].toString().toUpperCase(); // ignore upper and lowercase
        var valueB = b[field].toString().toUpperCase(); // ignore upper and lowercase
        if (valueA < valueB) {
          return -1;
        }
        if (valueA > valueB) {
          return 1;
        }
      
        // values must be equal
        return 0;
      });
    }else if(order == 'descending'){
      return data.sort(function(a, b) {
        var valueA = a[field].toString().toUpperCase(); // ignore upper and lowercase
        var valueB = b[field].toString().toUpperCase(); // ignore upper and lowercase
        if (valueA > valueB) {
          return -1;
        }
        if (valueA < valueB) {
          return 1;
        }
      
        // values must be equal
        return 0;
      });
    }
  }

  sortNumberAscending(data){
    return data.sort((a, b) => a - b);
  }
  sortNumberDescending(data){
    return data.sort((a, b) => b - a);
  }
}
