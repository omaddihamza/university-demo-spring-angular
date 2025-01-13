import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http:HttpClient) { }

  paymentList():Observable<any>{
    return this.http.get("http://localhost:8080/api/payments")
  }
}
