import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class NotificationMessageProvider {

  public INQUIRY: {REGISTER:{SUCCESS:string,FAILURE:string}, UPDATE:{SUCCESS:string,FAILURE:string}};
  public FORM: {INVALID:string};
  private inqRegisterSucessMessage;
  private inqRegisterFailureMessage;
  private inqUpdateSucessMessage;
  private inqUpdateFailureMessage;
  private formInvalidMessage;
  
  constructor(public http: HttpClient) {
    console.log('Hello NotificationMessageProvider Provider');
    this.setInqRegSuccessMsg("Inquiry Registered Successfully");
    this.setInqRegFailureMsg("Server retutned an error. Cannot register inquiry.");
    this.setInqUpdSuccessMsg("Inquiry Updated Successfully");
    this.setInqUpdFailureMsg("Server retutned an error. Cannot update inquiry.");
    this.setFormInvalidMsg("Invalid Form! Please fill proper values");
    this.INQUIRY = {
      REGISTER : {
        SUCCESS : this.getInqRegSuccessMsg(),
        FAILURE : this.getInqRegFailureMsg()
      },
      UPDATE : {
        SUCCESS : this.getInqUpdSuccessMsg(),
        FAILURE : this.getInqUpdFailureMsg()
      }
    }
  
    this.FORM = {
      INVALID : this.getFormInvalidMsg()
    }
  }

  setInqRegSuccessMsg(message){
    this.inqRegisterSucessMessage = message;
  }
  setInqRegFailureMsg(message){
    this.inqRegisterFailureMessage = message;
  }
  setInqUpdSuccessMsg(message){
    this.inqUpdateSucessMessage = message;
  }
  setInqUpdFailureMsg(message){
    this.inqUpdateFailureMessage = message;
  }
  setFormInvalidMsg(message){
    this.formInvalidMessage = message;
  }

  getInqRegSuccessMsg(){
    return this.inqRegisterSucessMessage;
  }
  getInqRegFailureMsg(){
    return this.inqRegisterFailureMessage;
  }
  getInqUpdSuccessMsg(){
    return this.inqUpdateSucessMessage;
  }
  getInqUpdFailureMsg(){
    return this.inqUpdateFailureMessage;
  }
  getFormInvalidMsg(){
    return this.formInvalidMessage;
  }

}
