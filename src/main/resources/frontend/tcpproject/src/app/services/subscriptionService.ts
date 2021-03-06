import {Injectable} from "@angular/core";
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Subscription } from "../models/subscription";
import {environment} from "../../environments/environment";
//import {EnvService} from "./env.service";

@Injectable()
export class SubscriptionService {
  private subscriptionUrl: string;
  private sendto: string;

  constructor(private http: HttpClient) {
    this.subscriptionUrl = environment.apiUrl + "/subscriptions";
  }

  public save(subscription: Subscription) {
    return this.http.post(this.subscriptionUrl, subscription);
  }

  public findByUserId(userId:number){
    this.sendto = environment.apiUrl +"/users/" + userId + "/subscriptions";
    return this.http.get<Subscription[]>(this.sendto);
  }

  public findByChannelId(channelId:number){
    this.sendto = environment.apiUrl +"/channels/" + channelId + "/subscriptions";
    return  this.http.get<Subscription[]>(this.sendto);
  }

  public createSubscriptions(subscriptions:Subscription[]){
    return this.http.post(this.subscriptionUrl+"/list", subscriptions);
  }

}

