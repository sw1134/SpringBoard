<img src="https://capsule-render.vercel.app/api?type=waving&color=BDBDC8&height=150&section=header" />
# 게시판 시스템 설명 문서

## 목차

- 개요
- 핵심-컴포넌트
- 작동-흐름
- 기타-기능
- 맺음말

## 개요

이 문서는 게시판 시스템의 구조, 기능, 작동 흐름 등을 자세하게 설명합니다. <br>
이 시스템은 사용자가 글을 작성하고, 읽고, 수정하고, 삭제할 수 있는 기능을 제공합니다.

## 핵심 컴포넌트

### Mapper (org.zerock.mapper.BoardMapper)

- **MyBatis 프레임워크**를 사용하여 데이터베이스와 상호작용합니다.
- **mapper namespace**: Mapper 인터페이스와 연결합니다.
- **select**: 데이터베이스에서 데이터를 조회합니다. (목록, 상세보기)
- **insert**: 데이터베이스에 데이터를 삽입합니다. (글쓰기)
- **insertSelectKey**: 삽입하면서 바로 생성된 기본키 (bno)를 가져옵니다.
- **update**: 데이터베이스의 데이터를 수정합니다.
- **delete**: 데이터베이스의 데이터를 삭제합니다.

## 작동 흐름

게시판 시스템의 작동 흐름은 사용자가 시스템에 요청을 보내면,<br>
Mapper를 통해 데이터베이스와 상호 작용하고,<br>
결과를 사용자에게 반환하는 과정으로 이루어집니다.

1. 사용자가 웹 페이지를 통해 글쓰기, 조회, 수정, 삭제 등의 요청을 합니다.
2. 컨트롤러가 요청을 받아서 처리할 서비스를 호출합니다.
3. 서비스는 필요한 데이터 처리를 위해 Mapper를 호출합니다.
4. Mapper는 MyBatis를 사용하여 실제 데이터베이스 작업을 수행합니다.
5. 데이터 처리 결과를 서비스를 통해 컨트롤러로 반환하고, 최종적으로 사용자에게 결과를 제공합니다.

## 기타 기능

- **검색**: 사용자가 키워드로 게시글을 검색할 수 있습니다.
- **페이징**: 대량의 게시물을 페이지별로 나누어 보여줍니다.
- **댓글**: 사용자가 게시글에 댓글을 달 수 있는 기능을 제공합니다.

[![Typing SVG](https://readme-typing-svg.demolab.com/?lines=수고+하셨+습+니다;감+사+합+니+다)](https://git.io/typing-svg)
[맨 위로](# 게시판 시스템 설명 문서)

<details>

<summary>
  <img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Hand%20gestures/Eyes.png" alt="Eyes" width="2%" /> 사용한 프로그램
</summary>
   <br>
  
 ![html](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![css](https://img.shields.io/badge/CSS-239120?&style=for-the-badge&logo=css3&logoColor=white) 
 ![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)  ![spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white) ![Oracle](https://img.shields.io/badge/Oracle-F80000.svg?&style=for-the-badge&logo=Oracle&logoColor=white)
![SQL_Developer](https://img.shields.io/badge/SQL_Developer-007396.svg?&style=for-the-badge&logo=SQL_Developer&logoColor=white)

</details>

<img src="https://capsule-render.vercel.app/api?type=waving&color=BDBDC8&height=150&section=footer" />

