import {Injectable} from "@angular/core";
import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Message } from "./message";
import { Observable} from "rxjs";

@Injectable()
export class MessageService{
  private messagesUrl: string;
  private sendto: string;

  constructor(private http: HttpClient){
    this.messagesUrl= 'https://teamac.herokuapp.com/messages';
  }

  public save(message: Message){
    return this.http.post(this.messagesUrl, message);
  }

  public findAll(channelId: number): Observable<Message[]> {

    this.sendto = 'https://teamac.herokuapp.com/messages/' + channelId;
    return this.http.get<Message[]>(this.sendto);
  }



}
