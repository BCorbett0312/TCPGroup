import {Injectable} from "@angular/core";
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Message } from "./message";
import { Observable} from "rxjs";
import {EnvService} from "../env.service";

@Injectable()
export class MessageService{
  private messagesUrl: string;
  private sendto: string;

  constructor(private http: HttpClient, private envserve: EnvService){
    this.messagesUrl= envserve.apiUrl + "/messages";
  }

  public save(message: Message){
    return this.http.post(this.messagesUrl, message);
  }

  public findAll(channelId: number): Observable<Message[]> {

    this.sendto = this.messagesUrl +"/" + channelId;
    return this.http.get<Message[]>(this.sendto);
  }



}
