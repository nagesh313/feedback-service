import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient) {

  }

  public getTopResponses() {
    return this.http.get('https://app-feedback-service.herokuapp.com/api/feedback');
  }

}
