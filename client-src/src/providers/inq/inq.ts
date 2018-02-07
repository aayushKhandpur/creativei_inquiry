import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class InqProvider {

  private baseUrl: string = 'http://localhost:9002/inquiry';
  private enums;

  constructor(public http: HttpClient,) {
    console.log('Hello InqProvider Provider');
  }

  getInqById(id){
    return this.http.get(this.baseUrl+'/getById',{
      params: new HttpParams().set('id', id)
    });
  }

  createInq(data){
    return this.http.post(this.baseUrl+'/register',data);
  }
  
  updateInq(data){
    return this.http.post(this.baseUrl+'/update',data);
  }

  setEnums(){
      this.http.get(this.baseUrl+'/server-info')
      .subscribe(
        data => {this.enums = data},
        error => {console.log("Error getting enums")},
        () => {console.log("Set enum complete")}
      );
  }
  getEnums(){
    if(this.enums){
      return this.enums;
    }else{
      this.setEnums();
      return this.enums;
    }
  }
}
