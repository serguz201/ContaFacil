import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manualuser',
  imports: [],
  templateUrl: './manualuser.component.html',
  styleUrl: './manualuser.component.css'
})
export class ManualuserComponent implements OnInit {
  private imageAttempts = 0;
  private imagePaths = [
    'Manual_2.png',
    '/Manual_2.png',
    'assets/images/Manual_2.png',
    './assets/images/Manual_2.png',
    '/assets/images/Manual_2.png',
    'Manual.png',
    'assets/images/Manual.png'
  ];

  ngOnInit() {
    console.log('🚀 ManualuserComponent inicializado');
    console.log('📁 Intentando cargar imagen:', this.imagePaths[0]);
  }

  onImageLoad(event: any) {
    console.log('✅ Imagen cargada correctamente:', event.target.src);
  }

  onImageError(event: any) {
    console.error('❌ Error al cargar la imagen:', event.target.src);
    this.imageAttempts++;
    
    if (this.imageAttempts < this.imagePaths.length) {
      console.log('🔄 Intentando con ruta alternativa:', this.imagePaths[this.imageAttempts]);
      event.target.src = this.imagePaths[this.imageAttempts];
    } else {
      console.error('💥 No se pudo cargar la imagen desde ninguna ruta');
      event.target.alt = 'Imagen no disponible - Manual no encontrado';
      event.target.style.display = 'none';
    }
  }
}
