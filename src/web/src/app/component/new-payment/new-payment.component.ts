import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {PaymetType} from "../../model/payment.model";
import {PaymentService} from "../../services/payment.service";

@Component({
  selector: 'app-new-payment',
  templateUrl: './new-payment.component.html',
  styleUrls: ['./new-payment.component.css']
})
export class NewPaymentComponent implements OnInit{

  studentCode !: string;
  paymentType : string[] = [];
  paymentFormGroup!:FormGroup;

   constructor(private fb:FormBuilder, private route :ActivatedRoute, private paymentService:PaymentService) {
   }
    ngOnInit(): void {

     for (let elm in PaymetType){
       let value = PaymetType[elm];
       if(typeof value === "string"){
         this.paymentType.push(value)
       }
     }
     this.studentCode = this.route.snapshot.params["code"];
      this.paymentFormGroup = this.fb.group({
        date: ['', Validators.required], // Required date field
        amount: ['', [Validators.required, Validators.min(1)]], // Required and minimum value 1
        studentCode: [ this.studentCode], // At least 3 characters
        type: ['', Validators.required], // Required dropdown
        fileName: ['', Validators.required] ,// Required file
        fileSource: ['', Validators.required] // Required file
      });
    }

  onFileSelected(event: any) {
    if (event.target.files.length > 0){
      let file = event.target.files[0];
      this.paymentFormGroup.patchValue({
        fileSource: file,
        fileName : file.name
      })
    }
  }

  onSubmit() {
     let date = new Date(this.paymentFormGroup.value.date);
     let formateDate = date.getDate()+"/"+(date.getMonth()+1)+"/"+date.getFullYear();
    if (this.paymentFormGroup.valid) {
      const formData = new FormData();
      // Append form controls to FormData
      formData.append('file', this.paymentFormGroup.value.fileSource);
      formData.append('date', formateDate);
      formData.append('amount', this.paymentFormGroup.value.amount);
      formData.append('type', this.paymentFormGroup.value.type);
      formData.append('studentCode', this.paymentFormGroup.value.studentCode);

      console.log(formData)
      this.paymentService.savePayment(formData).subscribe({

        next:Payment =>{
           alert("payment saved succesfully")

        },
        error:err => {
           console.log(err)
        }
      })

    } else {
      console.log('Form is invalid. Please fill out all required fields.');
    }
  }
}
