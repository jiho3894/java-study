
#define RCC_AHB1ENR     (*(volatile unsigned *)0x40023830)

#define GPIOB_MODER     (*(volatile unsigned *)0x40020400)
#define GPIOB_OTYPER    (*(volatile unsigned *)0x40020404)
#define GPIOB_OSPEEDR   (*(volatile unsigned *)0x40020408)
#define GPIOB_BSRR      (*(volatile unsigned *)0x40020418)

void main(void)
{
  // RCC_AHB1ENR setting - RCC Clock Enable/Disable set
  RCC_AHB1ENR |= 0x2;
  
  // GPIOx_MODER - Input/Output/Alternate function/Analog Mode set
  GPIOB_MODER |= 0x55555555;
  
  // GPIOx_OTYPER - Output Push-pull/Open-drain set
  GPIOB_OTYPER |= 0x00000000;
  
  // GPIOx_OSPEEDR - Output Speed set
  GPIOB_OSPEEDR |= 0x55555555;
  
  // GPIOx_BSRR - Bit reset/set(High(8)/Low(8) bit)
  GPIOB_BSRR |= 0x0000FF00;             // PORT_BH LED Á¡µî

  while(1)
  {
    ;
  }
}