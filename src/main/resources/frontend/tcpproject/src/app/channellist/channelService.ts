import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Channel } from "../channel";
import { Observable} from "rxjs";

import {environment} from "../../environments/environment";

@Injectable()
export class ChannelService{
  private channelsUrl: string;
  sendto: string;

  constructor(private http: HttpClient){
    this.channelsUrl= environment.apiUrl + "/channels";
  }

  public findAll(): Observable<Channel[]> {

    // this.sendto = this.channelsUrl + ;
    return this.http.get<Channel[]>(this.channelsUrl);
  }

}
