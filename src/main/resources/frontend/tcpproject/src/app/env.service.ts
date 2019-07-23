export class EnvService {

  // The values that are defined here are the default values that can
  // be overridden by env.js

  // API url
  public apiUrl = 'https://teamac.herokuapp.com'; // 'http://localhost:8080'; //

  // Whether or not to enable debug mode
  public enableDebug = true;

  constructor() {
  }

}
