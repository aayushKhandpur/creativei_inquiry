import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the LocalityProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class LocalityProvider {

  private baseUrl: string = 'http://localhost:9002/locality';

  constructor(public http: HttpClient) {
    console.log('Hello LocalityProvider Provider');
  }

  getLocality(pincode){
    return this.http.get(this.baseUrl+'/pincode', {
      params: new HttpParams().set('pincode', pincode)
    });
  }

}
