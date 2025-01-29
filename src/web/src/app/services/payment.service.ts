import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.development";

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  url= environment.backendHost;
  constructor(private http:HttpClient) { }

  paymentList():Observable<any>{
    return this.http.get(this.url+"payments")
  }
  paymentsByStudentList(code:any):Observable<any>{
    return this.http.get(`${this.url}students/${code}/payment`)
  }
  gePaymentFile(id :any):Observable<any>{
    return this.http.get(`${this.url}paymentFile/${id}`, { responseType: 'blob' })
  }
  savePayment(formData:any):Observable<any>{
    return this.http.post(`${this.url}payments`,formData)
  }
}
