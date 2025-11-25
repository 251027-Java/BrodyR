import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class TranslatorService {
  constructor(){}
  translationCounter:number = 0
}
