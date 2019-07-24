import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Channel } from "../channel";
import { Observable} from "rxjs";
import {EnvService} from "../env.service";

@Injectable()
export class ChannelService{
  private channelsUrl: string;
  sendto: string;

  constructor(private http: HttpClient, private envserv: EnvService){
    this.channelsUrl= envserv.apiUrl + "/channels";
  }

  public findAll(): Observable<Channel[]> {

    // this.sendto = this.channelsUrl + ;
    return this.http.get<Channel[]>(this.channelsUrl);
  }

}
