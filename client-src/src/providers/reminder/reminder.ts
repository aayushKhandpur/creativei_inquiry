import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ReminderProvider {

  private baseUrl: string = 'http://localhost:9002/reminder';

  constructor(public http: HttpClient) {
    console.log('Hello ReminderProvider Provider');
  }

  createReminder(data){
    return this.http.post(this.baseUrl+'/create', data);
  }

  getReminderForToday(){
    //todo
  }

  getReminderForRange(){
    //todo
  }

}
