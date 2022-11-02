- 기능 요구사항
- [x] 상품을 생성한다.
    - [x] 상품번호, 상품명, 판매가격, 재고수량
    - [x] 예외
        - [x] 판매가격이 음수
        - [x] 재고수량이 음수
- [x] 장바구니에 장바구니 상품을 담는다.
  - [x] 상품번호, 주문수량을 입력받는다.
  - [x] 예외
    - [x] CartProducts 가 null 이면 예외
    - [x] List size가 0이면 예외
  - [x] 장바구니 상품
    - [x] 예외
      - [x] quantity가 음수
      - [x] price가 음수
- [ ] 상품을 주문한다.
    - [x] 한번에 여러개의 상품을 주문할 수 있다.
    - [x] 반복적으로 계속 주문할 수 있다.
    - [x] 주문 내역, 주문 금액, 결제 금액 (배송비 포함) 화면에 출력
    - [ ] 예외
      - [x] 주문 상품들이 null 이면 예외
      - [x] 주문 상품들 size가 0이면 예외
      - [ ] 주문 상품 수량이 재고량보다 크면 (상품의 재고가 부족하면) `SoldOutException`
    - [x] 주문 상품을 생성한다.
      - [x] 장바구니로부터 장바구니 상품의 정보를 복사해 생성한다.
      - [x] 예외
        - [x] cartProductId가 null 이면 예외
        - [x] 주문 수량이 음수
        - [x] productId가 없으면
    - [x] 주문 금액이 `50,000`원 이하일 경우 배송료 `2,500` 원 추가
- [ ] 프로그램 컨트롤
    - [x] 데이터 불러오기
    - [x] `o` 입력시 상품 출력 (상품번호, 상품명, 판매가격, 재고수)
    - [x] 주문하기
        - [x] 상품번호 입력
        - [x] 수량 입력
    - [x] `empty` 입력 (`space + ENTER`) 이 되었을 경우 주문이 완료되고 결제
        - [x] 주문 내역 출력
            - [x] 상품 리스트
            - [x] 주문 금액
            - [x] 지불 금액 (주문 금액 + 배송비 - 2,500) - 주문 금액 5만원 이상시 배송비 면제
    - [x] 다시 `o`, `q` 입력 가능 상태
    - [x] `q` 또는 `quit` 입력시 프로그램 종료
    - [ ] 예외
      - [ ] 사용자 입력 잘못되면 예외
