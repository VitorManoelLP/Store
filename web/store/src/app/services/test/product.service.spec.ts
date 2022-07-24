import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { ProductService } from './../product.service';
describe('product.service.ts', () => {
  let service: ProductService;
  let httpClientMock: any;

  beforeAll(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule],
    });

    httpClientMock = jasmine.createSpyObj('httpClient', ['get']);
    httpClientMock.get.and.callFake(() => of([]));

    service = new ProductService(httpClientMock);
  });

  it('should call resource + page-all when called method', () => {
    service.findAllPageable();
    expect(httpClientMock.get).toHaveBeenCalledWith(
      'http://localhost:8081/api/page-all'
    );
  });
});
