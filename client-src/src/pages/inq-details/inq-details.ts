import { Component } from '@angular/core';
import { NavController, NavParams, LoadingController, AlertController } from 'ionic-angular';
import { TitleCasePipe } from '@angular/common';
import { FormGroup } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { CompleterService, RemoteData, CompleterItem } from 'ng2-completer';

import { InqProvider } from '../../providers/inq/inq';
import { NotificationProvider } from '../../providers/notification/notification';
import { NotificationMessageProvider } from '../../providers/notification-message/notification-message';
import { LocalityProvider } from '../../providers/locality/locality';
import { HelperProvider } from '../../providers/helper/helper';
import { ThankyouPage } from '../thankyou/thankyou';

@Component({
  selector: 'page-inq-details',
  templateUrl: 'inq-details.html',
})
export class InqDetailsPage {

  private pinService: RemoteData;
  private localities;
  private areas;
  private city;
  private state;
  private country;
  private enums;
  private genders;
  private hQualifications;
  private computerKnowledge;
  private areasOfInterest;
  private streams;
  private eduStatus;
  private eduType;
  private markScheme;
  private guardianRelation;
  private guardianOccupation;
  private enqSource;
  private responseData;
  private currentInqId;
  private currentInqAddressId;
  private currentInqEducationId;
  private currentInqGuardianId;
  private currentInqMarketingId;
  private currentInq;
  private requestData;

  private inqForm: FormGroup;

  today : string = new Date().toISOString();

  constructor(public navCtrl: NavController, public navParams: NavParams, private formBuilder: FormBuilder, private loadingCtrl: LoadingController, private alertCtrl: AlertController, private inqProvider: InqProvider, private notify: NotificationProvider, private message: NotificationMessageProvider, private localityProvider: LocalityProvider, private helper: HelperProvider, private completerService: CompleterService) {

    this.updateInq();
    
    this.inqForm = this.formBuilder.group({
      name: ['', Validators.required],
      gender: ['', Validators.required],
      dob: ['', Validators.required],
      address: this.formBuilder.group({
        addressLine1: [''],
        locationId: ['', Validators.required],
        pin: ['', Validators.required]
      }),
      mobile: ['', [Validators.required,Validators.minLength(10),Validators.maxLength(10)]],
      email: ['', [Validators.required, Validators.email]],
      hQualification: ['', Validators.required],
      computerKnowledge: ['', Validators.required],
      areaOfInterest: ['', Validators.required],
      education: this.formBuilder.array([
        this.formBuilder.group({
          educationQualification: [''],
          instituteName: [''],
          stream: [''],
          status: [''],
          year: [''],
          type: [''],
          aggregateMarks: [''],
          markScheme: ['']
        })
      ]),
      guardian: this.formBuilder.group({
        name: [''],
        relation: [''],
        phoneNumber: ['',[Validators.minLength(10),Validators.maxLength(10)]],
        email: ['',Validators.email],
        occupation: ['']
      }),
      marketing: this.formBuilder.group({
        source: [''],
        referred: [false],
        referant: ['']
      })
    });

    this.setEnums();
    this.setGenders();
    this.setQualifications();
    this.setComputerKnowledge();
    this.setAreasOfInterest();
    this.setStreams();
    this.setEduStatus();
    this.setEduType();
    this.setMarkScheme();
    this.setGuardianRelation();
    this.setGuardinaOccupation();
    this.setMarketingSource();
    this.pinService = this.completerService.remote(null);
    this.pinService.urlFormater(term => {
      return `http://localhost:9002/pincodes?pincode=${term}`;
    });
    this.pinService.dataField("data");
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad InqDetailsPage');
  }

  private loading;

  presentLoadingCustom() {
    this.loading = this.loadingCtrl.create({
      spinner: 'hide',
      content: `
        <img src="../../assets/imgs/loading.svg" />
      `
    });
    this.loading.onDidDismiss(() => {
      console.log('Dismissed loading');
    });

    this.loading.present();
  }
  logForm() {
    if(this.inqForm.valid){
      if(this.currentInq){
        this.requestData = Object.assign({},this.inqForm.value);
        this.requestData.id = this.currentInqId;
        this.requestData.address.id = this.currentInqAddressId;
        this.requestData.education[0].id = this.currentInqEducationId;
        this.requestData.guardian.id = this.currentInqGuardianId;
        this.requestData.marketing.id = this.currentInqMarketingId;
      }else{
        this.requestData = Object.assign({},this.inqForm.value);
      }
      console.log("Form to be logged", this.requestData);
      this.presentLoadingCustom();
      this.inqProvider.createInq(this.requestData)
        .subscribe(
        data => { 
          this.responseData = data;
          if(this.responseData.data){
            this.notify.showInfo(this.message.INQUIRY.REGISTER.SUCCESS);
            console.log("POST successful, the response data is:", data);
          }else{
            this.notify.showError(this.message.INQUIRY.REGISTER.FAILURE);
            console.log("POST unsucessful, server responded with error", this.responseData.exception);
          }
        },
        error => { console.log("POST unsuccessful, the server returned this error:", error); this.loading.dismissAll(); },
        () => {
          console.log("complete");
          this.loading.dismissAll();
          if(this.responseData.data){
            this.navCtrl.setRoot(ThankyouPage);
          }
        }
        );
    }else{
      this.notify.showError(this.message.FORM.INVALID);
    }
  }

  updateInq(){
    if(typeof this.navParams.data === 'number'){
      this.currentInqId = this.navParams.data;
      console.log("Inquiry ID to be edited is",this.currentInqId);
      this.presentLoadingCustom();
      this.inqProvider.getInqById(this.currentInqId)
        .subscribe(
          data => {
            this.currentInq = data;
          },
          error => { console.log("GET unsucessful, the server returned this error:", error), this.loading.dismissAll(); },
          () => {
            console.log("complete");
            this.patchData(this.currentInq.data);
            this.getLocality(this.currentInq.data.address.pin);
            this.currentInqAddressId = this.currentInq.data.address.id;
            this.currentInqEducationId = this.currentInq.data.education[0].id;
            this.currentInqGuardianId = this.currentInq.data.guardian.id;
            this.currentInqMarketingId = this.currentInq.data.marketing.id;
            this.loading.dismissAll();
          }
        )
    }
  }

  patchData(inq){
    let patch = this.helper.removeEmptyFromObject(inq);
    console.log("Object to be patched:", patch);
    this.inqForm.patchValue(patch);
  }

  isInqOpen(status){
    if(status.toLowerCase() == "open"){
      return true;
    }else return false;
  }

  changeInqStatus(e){
    console.log(e.target.value);
    if(e.target.value == "close"){
      this.showClosingRemarkAlert();
    }
  }

  showClosingRemarkAlert(){
    let alert = this.alertCtrl.create({
      title: 'Closing Inquiry',
      message: "Enter the closing remarks for this inquiry",
      inputs: [
        {
          name: 'remarks',
          placeholder: 'Remarks'
        },
      ],
      buttons: [
        {
          text: 'Cancel',
          handler: data => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Save',
          handler: data => {
            console.log('Saved clicked', data);   //data.remarks is the data entered in the input box
          }
        }
      ]
    });
    alert.present();
  }

  setLocality(locality){
    this.city = locality.data.city;
    this.state = locality.data.state;
    this.country = locality.data.country;
    this.areas = this.helper.sortLocalityByName(locality.data.locality);
  }

  getLocality(pincode){
    console.log("Getting localities for: ",pincode)
    this.localityProvider.getLocality(pincode)
      .subscribe(
        data => {console.log(data), this.localities = data;},
        error => {console.log("ERROR GETTING LOCALITIES")},
        () => {console.log("COMPLETE"), this.setLocality(this.localities);}
      )
  }

  onPincodeSelected(pincode: CompleterItem){
    if(pincode){
      console.log(pincode);
      this.getLocality(pincode.originalObject);
    }
  }

  setEnums(){
    this.enums = this.inqProvider.getEnums();
  }
  setGenders(){
    this.genders = this.enums.data.gender;
  }
  setQualifications(){
    this.hQualifications = this.enums.data.highestEducation;
  }
  setComputerKnowledge(){
    this.computerKnowledge = this.enums.data.computerKnowledge;
  }
  setAreasOfInterest(){
    this.areasOfInterest = this.enums.data.areaOfInterest;
  }
  setStreams(){
    this.streams = this.enums.data.stream;
  }
  setEduStatus(){
    this.eduStatus = this.enums.data.educationStatus;
  }
  setEduType(){
    this.eduType = this.enums.data.educationType;
  }
  setMarkScheme(){
    this.markScheme = this.enums.data.markScheme;
  }
  setGuardianRelation(){
    this.guardianRelation = this.enums.data.relation;
  }
  setGuardinaOccupation(){
    this.guardianOccupation = this.enums.data.occupation;
  }
  setMarketingSource(){
    this.enqSource = this.enums.data.marketingSource;
  }

}
