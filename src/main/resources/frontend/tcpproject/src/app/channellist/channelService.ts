import {Injectable} from "@angular/core";
import { HttpClient} from "@angular/common/http";
import { Channel } from "../channel";
import { Observable} from "rxjs";

@Injectable()
export class ChannelService{
  private channelsUrl: string;
  sendto: string;

  constructor(private http: HttpClient){
    this.channelsUrl= 'https://teamac.herokuapp.com/channels';
  }

  public findAll(): Observable<Channel[]> {

    this.sendto = 'https://teamac.herokuapp.com/channels';
    return this.http.get<Channel[]>(this.sendto);
  }

}
