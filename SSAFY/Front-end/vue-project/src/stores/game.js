import router from '@/router'
import axios from 'axios'
import { defineStore } from 'pinia'
import { ref } from 'vue'

// store 
export const useGameStore = defineStore('gameInfo', () => { 

    // 뉴 스포츠 정보
    const gameInfo = ref([
        {id: 1, koName: "티볼", enName: "Tee-Ball", 
            photo: "http://www.nsns.co.kr/theme/basic/img/sub/t_ball01.gif", 
            info1:"전문적인 기술과 장소, 도구 등을 사용하지 않고도 야구형 스포츠의 흥미를 남녀노소 누구나 안전하게 즐길 수 있도록 고안된 경기이다.", 
            info2: "티 위에 공을 올려놓고 치는 게임으로서 결과에 대한 기쁨이나 책임도 모두에게 골고루 돌아간다. 티볼은 안전한 공과 베트, 작은경기장, 쉬운 기술 등을 이용해 누구나 쉽게 야구형 팀 스포츠에 참가 할 수 있게 하여 야구의 즐거움을 만끽할 수 있다.", 
            info3: "시합은 다음의 3가지 방법으로 할 수 있다. a. 두 팀이 공격과 수비로 나뉘어 공격 측의 타자 모두가 타격을 완료했을 때(전원타격제) 공수를 교대하고, 규정 회수(이닝)를 끝냈을 때 득점이 많은 팀이 승자가 된다. 이 경우에 잔루의 주자는 다음 이닝에 이어지는 것으로 한다. 단, 최종회에는 적용하지 않는다. b. 두 팀이 공격과 수비로 나뉘어 공격 측의 7명의 타자가 타격을 완료했을 때 공수를 교대하고, 규정 회수(이닝)를 끝냈을 때 득점이 많은 팀이 승자가 된다. 이 경우에 잔루의 주자는 다음 이닝에 이어지는 것으로 한다. 단, 최종회에는 적용하지 않는다. c. 두 팀이 공격과 수비로 나뉘어 쓰리 아웃이 되면 공수를 교대하고, 규정 회수(이닝)를 끝냈을 때 득점이 많은 팀이 승자가 된다.",
            rulesUrl: "https://www.youtube.com/watch?v=FD72fVvoeX0", 
            videoUrl: "https://www.youtube.com/watch?v=UpZxh9Z3iYQ"}, 
        {id: 2, koName: "빅발리볼", enName: "Vic-Volleyball", 
            photo: "http://www.nsns.co.kr/theme/basic/img/sub/softbal01.gif", 
            info1: "빅발리볼은 배구와 같이 비어있는 상대편 코트로 공을 넘겨 득점하는 배구형 스포츠이다.", 
            info2: "배구공보다 크고(지름 약 50cm) 가벼운 빅발리볼을 이용하므로 더 안전하고 쉽게 배울 수 있으며 배트민턴 네트를 이용하여 게임할 수도 있다.", 
            info3: "15점 3세트 중 2세트 승리한 팀이 승리하며, 배구룰과 동일하게 듀스제(2점 차이)를 적용한다. 듀스 진행시, 21점 먼저 획득 팀이 승리한다. 터치는 5번 이내로 상대팀에 넘겨야 한다.", 
            rulesUrl: "https://www.youtube.com/watch?v=JiyXdVsRE30", 
            videoUrl: "https://www.youtube.com/watch?v=I_xRiSVpdIw"}, 
        {id: 3, koName: "인디아카", enName: "Indiaca", 
            photo: "http://www.nsns.co.kr/theme/basic/img/sub/indiana01.gif", 
            info1: "인디아카는 배구와 배트민턴, 그리고 탁구의 재미를 라켓이 아닌 손바닥으로 직접 인디아카를 상대편에 넘기는 뉴스포츠이다.", 
            info2: "6인제 배구의 규정에 의해 인디아카를 맨손으로 쳐서 상대팀의 코트에 넘김으로서 득점을 하는 게임이다. 배구와 배드민턴의 리드업 게임으로서 배구나 배드민턴의 기본기를 익히는데 매우 효과적이다.", 
            info3: "독일에서 탄생한 인디아카는 유럽은 물론, 중국, 일본 등에서도 널리 알려지고 있으며 노인체육종목으로서도 각광을 받는 종목이기도 하다.", 
            rulesUrl: "https://www.youtube.com/watch?v=39_213D6coQ", 
            videoUrl: null}, 
        {id: 4, koName: "츄크볼", enName: "Tchouball", 
            photo: "http://www.nsns.co.kr/theme/basic/img/sub/chouckball01.gif", 
            info1: "츄크볼은 1920년에 스위스의 생물학자 H.브랜드리가 팀 게임의 과학적 비판이라는 논문에서 종래의 구기운동을 침략적이라고 규정하고 그 대안으로 비침략적인 게임을 구상하면서 만들어졌다.", 
            info2: "탄력성이 있는 약 1M의 네트에 볼을 던져 튀어 오른 볼이 상대팀에게 잡히지 않도록 하는 경기이다. 학교 수업에서는 핸드볼의 리드 업 게임으로 적극 활용할 가치가 있다.", 
            info3: "일반적인 팀 게임과의 큰 차이는 상대의 볼을 빼앗거나 방해해서는 안 된다는 점이다. 그 때문에 구기에 익숙하지 않았던 사람들도 쉽게 즐길 수 있다. 그러나 상대팀의 움직임이나, 슛된 볼의 낙하지점을 예측하면서 움직이는 것이 요구되는 스포츠이다.", 
            rulesUrl: "https://www.youtube.com/watch?v=HkS8fY-se9E", 
            videoUrl: "https://www.youtube.com/watch?v=ow7YRheQbp8"}, 
        {id: 5, koName: "플로어볼", enName: "Floorball", 
            photo: "http://www.nsns.co.kr/theme/basic/img/sub/floorball01.gif", 
            info1: "플로어볼은 하키형 뉴스포츠이다. 무겁고 딱딱한 스틱 대신 플라스틱으로 만들어진 가볍고 안전한 스틱으로 경기를 진행합니다.", 
            info2: "볼은 플라스틱제의 가볍고 안전한 소재로 제작되었다. 유럽에서는 다양한 지역대회를 개최할 정도로 많이 소개되고 아시아권에서도 일본, 중국, 대만 등에서 활발하게 전개되고 있는 종목이다.", 
            info3: "플로어볼은 일반적으로 농구와 같이 필드선수 5명이 전원 공격과 전원 수비의 형태로 경기를 진행한다. 득점인정의 기준은 공의 모든 부분이 완벽히 골라인을 통과한 경우이다. 경기 중 선수 교체의 제한은 없다. 경기 중 가장 많이 발생하는 반칙은 스틱과 몸에 의한 반칙으로 발생한 지점에 볼을 놓고 Free-hit 상황을 진행한다. 플로어볼 경기의 작전타임 시간은 30초이며 경기 당 1회 사용할 수 있으며 팀의 주장이나 코칭스태프가 심판에게 요청할 수 있다.", 
            rulesUrl: "https://www.youtube.com/watch?v=U3yFGB8m8fQ", 
            videoUrl: "https://www.youtube.com/watch?v=hjFYsvP3_8M"}, 
        {id: 6, koName: "스포츠스태킹", enName: "Sport Stacking", 
            photo: "http://www.nsns.co.kr/theme/basic/img/sub/sport01.gif", 
            info1: "스포츠스태킹은 1980년대 초 미국 서해안의 어린이들이 종이컵으로 놀이를 하던 것에서 유래되어 1990년대 중반에 스포츠로서의 체계를 구축하면서 교육현장에 보급되기 시작하였다.", 
            info2: "12개의 스택컵을 다양한 방법으로 쌓고 또 허물어가는 기술과 스피드를 가려 집중력과 순발력을 요구하는 뉴스포츠이다.", 
            info3: "가장 기초적인 3스택의 경우 컵을 3개 포개 둔 상태에서 시작한다. 오른손으로 맨 위의 컵을 잡아 나머지 2개의 컵 오른쪽에 두고, 다음에는 왼손으로 2번째의 컵을 나란히 놓인 컵 위에 피라미드형으로 쌓아올린다. 다운스택은 '아래로 밀어 낸다'라는 의미이다. 오른손으로 맨 위의 컵을 쥐고 아래 단의 오른쪽으로 밀어내듯이 하여 아래로 밀어낸다. 왼손으로 아래 단의 왼쪽 컵을 쥐어 2개로 쌓아진 컵 위에 쌓는다. 이렇게 되면 최초의 형태가 된다. 양손을 동시에 사용하게 됨으로써 빠른 스택이 가능하게 된다.", 
            rulesUrl: "https://www.youtube.com/watch?v=4wpsOs0Eluk", 
            videoUrl: "https://www.youtube.com/watch?v=tZPen9QK9Hg"}, 
        // {id: 1, koName: "티볼", enName: "Tee-Ball", info:"전문적인 기술과 장소,도구 등을 사용하지 않고도 야구형 스포츠의 흥미를 남녀노소 누구나 안전하게 즐길 수 있도록 고안된 경기이다. 티 위에 공을 올려놓고 치는 게임으로서 결과에 대한 기쁨이나 책임도 모두에게 골고루 돌아간다.티볼은 안전한 공과 베트,작은경기장, 쉬운 기술 등을 이용해 누구나 쉽게 야구형 팀 스포츠에 참가 할 수 있게 하여 야구의 즐거움을 만끽할 수 있다."}, 
        // {id: 2, koName: "커롤링", enName: "Curolling", info: "동계올림픽 종목으로 널리 알려진 빙상스포츠 '컬링'에서 착안하여 빙상이 아닌 실내공간의 일반적인 플로어에서 누구나 쉽게 즐길 수 있는 새로운 형태의 스포츠이다. 플로어에서 1팀 3명의 플레이어가 6개의 제트롤러를 코트의 선단에 있는 직경 90cm의 포인트존을 향하여 상대팀의 플레이어와 제트롤러를 순서대로 굴려서 득점을 가리게 되는 경기이다. 특별한 기술이나 힘이 필요한 경기가 아니기 때문에 유아에서부터 고령자에 이르기까지 누구나가 함께 어울려 쉽게 즐길 수 있는 뉴스포츠이다. 질서의식고취, 집중력 향상, 치매방지 등에 매우 효과가 높아 어린이, 장애인, 고령자에게 적합하다."}, 
        // {id: 3, koName: "플라잉디스크", enName: "Flyingdisc", info: "플라잉디스크를 사용하는 경기는 누구라도 손쉽게 할 수 있는 레크레이션 스포츠로의 성격이 강한 스포츠이다. 스포츠 종목까지 매우 다양하여 남녀노소를 불문하고 누구라도 즐길 수 있다. 프리즈비는 1999년 AP통신 선정 20세기 10대 히트 발명품 중의 하나이며, 뉴욕타임즈가 미래의 스포츠라고 격찬한 바 있는 전 세계 6000 만 동호인, 경기자수 700만에 육박하는 대중스포츠이다.  세계 플라잉디스크연맹(WFDF)의 가맹 및 준 가맹국은 약 50여 개국이며, 1989년에는 디스크골프와 얼티미트 경기가 IOC가 후원하는 비 올림픽종목의 세계대회인 「월드게임즈」의 시범종목이 되었다. 이 종목들은 2001년 8월 일본의 아키타 월드게임즈에서 정식경기로 채택되었다."}, 
        // {id: 4, koName: "핸들러", enName: "Handler", info: "탁구(ping-pong)와 배드민턴(badminton)을 접목시켜 개발된 스포츠로서 ‘패드민턴’ 이라고도 불린다. 두뇌를 많이 사용하게 되며, 적당한 운동량을 지닌 뉴스포츠이다.배드민턴은 라켓이 길어 여학생이나 초등학생이 셔틀콕을 맞추기가 어려워 쉽게 즐길 수 없는 단점을 극복한 게임이다.라켓 길이가 짧고, 딱딱한 판으로 치기 때문에 셔틀콕이 멀리 날아가지 않는다. 이러한 특성 때문에 좁은 공간에서 쉽게 운동할 수 있고 빠른 경기진행이 짧은 시간에 많은 운동효과를 거둘 수 있게 한다. 단식,복식 등 게임이 가능하다. 양손으로 즐길 수 있기 때문에 균형감각 향상에 효과적이다."}, 
        // {id: 5, koName: "셔플보드", enName: "Shuffleboard", info: "볼링의 레인과 같은 양면에 거터(고랑)가 있는 콘크리트제의 장방형의 코트 상에서 2명씩 점수를 겨루는 게임이다.주로 두뇌를 많이 사용하게 되며, 적당한 운동량을 지닌 뉴스포츠이다. 주로 어린이나 고령자에게 적합한 운동이라고 할 수 있다. 남녀노소의 구분 없이 게임을 즐길 수 있어서 전 연령이 함께 즐길 수 있는 가족형 스포츠라고 할 수 있다."}, 
        // {id: 6, koName: "소프트발리볼", enName: "Soft-Volleyball", info: "소프트 발리볼은 특수소재로 부드럽게 만들어진 볼을 6인제, 9인제 배구의 규정에 의해 배구의 즐거움을 맛볼 수 있도록 만든 뉴스포츠이다. 소프트발리볼 공은 우선 특이하게 생겨서 공과 쉽게 친해진다. 여학생들도 ‘아프지 않다’는 점 때문에 공을 좋아하게 된다. 혼자서 할 수 있는 플레이가 없는 경기이기 때문에 내가 잘 하기 위해서는 다른 팀원의 도움이 필요하다. 승패의 원인을 ‘우리’로 보게 하여, 경쟁보다는 팀워크에 관심을 갖게 한다."}, 
        // {id: 7, koName: "프리테니스", enName: "Freetennis", info: "프리테니스는 테니스의 10분의 1정도의 코트에서 할 수 있는 뉴스포츠이다. 손쉽고 다이나믹한 동작을 가진 스포츠이고 또 자유롭게 즐기는 스포츠로 있기를 바라는 마음에서 프리테니스로 명명 했습니다. 테니스에 비해서 라켓이 짧고 코트가 작기 때문에 연령 성별에 관계없이 누구나 가볍게 참가 할 수 있는 스포츠이다. 생활체육과 가족 스포츠로 좁은 공간에서 즐길 수 있습니다."}, 
        // {id: 8, koName: "인디아카", enName: "Indiaca", info: "인디아카는 배구와 배트민턴, 그리고 탁구의 재미를 라켓이 아닌 손바닥으로 직접 인디아카를 상대편에 넘기는 뉴스포츠이다. 6인제 배구의 규정에 의해 인디아카를 맨손으로 쳐서 상대팀의 코트에 넘김으로서 득점을 하는 게임이다. 배구와 배드민턴의 리드업 게임으로서 배구나 배드민턴의 기본기를 익히는데 매우 효과적이다. 독일에서 탄생한 인디아카는 유럽은 물론, 중국, 일본 등에서도 널리 알려지고 있으며 노인체육종목으로서도 각광을 받는 종목이기도 하다."}, 
        // {id: 9, koName: "플링고", enName: "Flingo", info: "Flingo는 보다 독특하고 박진감 넘치는 게임이다. Bounce Effect 이라는 효과는 이용하여 즐기는 스포츠이다. Bounce Effect 를 물리적으로 설명하면 대략 아래와 같다. 엘라스틱 원단 소재의 Flingo가 공이 임팩트 하는 순간 공의 운동 에너지를 저장했다가 탄성에너지를 공에 되돌려 주는 효과이다. 특히 놀라운 점은 Flingo 게임 중 공에게 되돌려진 에너지(반탄력)는 우리가 예상하는 것보다 몇 배 더 강하게 전달하기 때문에 예측하기 힘들다. 또한 공은 플레이어의 몸과 팔의 움직임에 따라 단순한 탄성보다 더욱 많은 에너지를 전달받게 된다. 공원이나 체육관등에서 박진감 넘치는 게임을 즐길 수 있다."}, 
        // {id: 10, koName: "스포찬", enName: "Spochan", info: "스포찬이란 일본에서 진검승부의 스포츠화를 연구하여 1971년 국제 호신도 연맹을 조직한 것이 스포찬(스포츠찬바라)의 시초가 되었으며 에어소프트 검과 머리를 보호하는 헤드기어를 착용하고 공격과 방어의 호신기법으로 겨루는 뉴스포츠입니다. 정통검도에서 수련은 수련대로 고수하면서 현대에 맞게 재구성된 호신검도의 필요성을 인식하고 그 기술들을 실전처럼 적용해 언제나 어디서든 누구나 쉽게 즐길 수 스포츠로 재 탄생시켜 또 하나의 수련 장르로 수련되어지고 있습니다."}, 
        // {id: 4, koName: "스포찬", enName: "Spochan", info: "스포찬이란 일본에서 진검승부의 스포츠화를 연구하여 1971년 국제 호신도 연맹을 조직한 것이 스포찬(스포츠찬바라)의 시초가 되었으며 에어소프트 검과 머리를 보호하는 헤드기어를 착용하고 공격과 방어의 호신기법으로 겨루는 뉴스포츠입니다. 정통검도에서 수련은 수련대로 고수하면서 현대에 맞게 재구성된 호신검도의 필요성을 인식하고 그 기술들을 실전처럼 적용해 언제나 어디서든 누구나 쉽게 즐길 수 스포츠로 재 탄생시켜 또 하나의 수련 장르로 수련되어지고 있습니다."}, 
        // {id: 11, koName: "츄크볼", enName: "Tchouball", info: "츄크볼은 1920년에 스위스의 생물학자 H.브랜드리가 팀 게임의 과학적 비판이라는 논문에서 종래의 구기운동을 침략적이라고 규정하고 그 대안으로 비침략적인 게임을 구상하면서 만들어졌다 탄력성이 있는 약 1M의 네트에 볼을 던져 튀어 오른 볼이 상대팀에게 잡히지 않도록 하는 경기이다. 학교 수업에서는 핸드볼의 리드 업 게임으로 적극 활용할 가치가 있다. 일반적인 팀 게임과의 큰 차이는 상대의 볼을 빼앗거나 방해해서는 안 된다는 점이다. 그 때문에 구기에 익숙하지 않았던 사람들도 쉽게 즐길 수 있다. 그러나 상대팀의 움직임이나, 슛된 볼의 낙하지점을 예측하면서 움직이는 것이 요구되는 스포츠이다."}, 
        // {id: 12, koName: "태극유력구", enName: "Taegeuk", info: "태극유력구는 중국에서 신종 대중 스포츠로 급부상하고 있는 게임이다. ‘태극유력구’는 산시성의 체육교사인 바이룽이 1991년 태극권의 원리에 테니스, 배드민턴 등 현대 구기 기술을 결합해 만든 신종 건강증진 운동으로 중국에서는 10년 전부터 전국 체육대회 정식종목으로 채택된 바 있다. 당초에는 노인들의 건강증진을 위해 개발한 스포츠였으나 지금은 젊은이들도 즐기는 스포츠가 되었다."}, 
        // {id: 13, koName: "킨볼", enName: "Kinball", info: "「킨볼」은 1984년에 캐나다의 마리오 듀마스씨가 고안하였습니다. 종래의 볼게임의 개념을 초월한 볼의 크기와 가벼움으로 어린이부터 성인에 이르기까지 기분 좋게 사용할 수 있다. 특히, 유아나 어린이들에게는 만지지 않고서는 못 베길 정도로 흥미로워 자연스럽게 볼을 밀어보거나 발로 차보거나 하여 직접 몸을 움직이게 하는 즐거움을 체험하게 할 수 있다. 정식 경기에서는 동시에 3팀(한 팀에 4명)이 참가하여 히트, 리시버를 해가면서 득점을 겨루게 되는 특징이 있다."}, 
        // {id: 14, koName: "플로어볼", enName: "Floorball", info: "플로어볼은 하키형 뉴스포츠이다. 무겁고 딱딱한 스틱 대신 플라스틱으로 만들어진 가볍고 안전한 스틱으로 경기를 진행합니다. 볼은 플라스틱제의 가볍고 안전한 소재로 제작되었다. 유럽에서는 다양한 지역대회를 개최할 정도로 많이 소개되고 아시아권에서도 일본, 중국, 대만 등에서 활발하게 전개되고 있는 종목이다."}, 
        // {id: 15, koName: "스포츠스태킹", enName: "Sport Stacking", info: "스포츠스태킹은 1980년대 초 미국 서해안의 어린이들이 종이컵으로 놀이를 하던 것에서 유래되어 1990년대 중반에 스포츠로서의 체계를 구축하면서 교육현장에 보급되기 시작하였다. 12개의 스택컵을 다양한 방법으로 쌓고 또 허물어가는 기술과 스피드를 가려 집중력과 순발력을 요구하는 뉴스포츠이다."}, 
    ])

    return {
        gameInfo, 
    }

})
