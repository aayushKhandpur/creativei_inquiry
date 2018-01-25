import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class HelperProvider {

  constructor(public http: HttpClient) {
    console.log('Hello HelperProvider Provider');
  }

  sortLocalityByName(data){
    return data.sort(function(a, b) {
      var valueA = a.name.toUpperCase(); // ignore upper and lowercase
      var valueB = b.name.toUpperCase(); // ignore upper and lowercase
      if (valueA < valueB) {
        return -1;
      }
      if (valueA > valueB) {
        return 1;
      }
    
      // values must be equal
      return 0;
    });
  }

  sortNumber(data){
    return data.sort((a, b) => a - b);
  }

}
