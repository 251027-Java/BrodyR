import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TranslatorService } from '../../services/translator-service';

@Component({
  selector: 'app-translate',
  imports: [FormsModule, CommonModule],
  templateUrl: './translate.html',
  styleUrl: './translate.css',
})
export class Translate {
constructor(public translatorService:TranslatorService){}

  englishText:string = ""
  pigLatinText:string = ""

  translate(){
    if(!this.englishText){
      alert("Please type something before translating!")
      return
    }
    const words = this.englishText.split(/\b/);
    const translatedWords = words.map(word => {
      if (/^[a-zA-Z]+$/.test(word)) {
        if (/^[aeiouAEIOU]/.test(word)) {
          return word + 'way';
        } else {
          const match = word.match(/^([^aeiouAEIOU]+)(.*)$/);
          return match ? match[2] + match[1] + 'ay' : word;
        }
      }
      return word;
    });
    this.pigLatinText = translatedWords.join('');
    this.translatorService.translationCounter++
  }
}
