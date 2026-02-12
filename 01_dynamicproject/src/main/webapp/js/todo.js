// DOM 요소 선택
const addBtn = document.querySelector("#add-btn");
const input = document.querySelector(".input-box>input");

// 입력 버튼 클릭 이벤트
addBtn.addEventListener("click", function() {
    addTodo();
});

// 입력 필드에서 엔터 키 이벤트
input.addEventListener("keyup", function(event) {
    if (event.key === "Enter") {
        addTodo();
    }
});

// 목록 영역 클릭 이벤트 (하트, 체크, 삭제 버튼 처리)
const listBox = document.querySelector(".list-box");
listBox.addEventListener("click", function(event) {
    // 하트 아이콘 토글 (좋아요 기능)
    const likeTarget = event.target.closest(".todo-like");
    if (likeTarget && listBox.contains(likeTarget)) {
        likeTarget.classList.toggle("liked");
        return;
    }

    // 체크 아이콘 클릭 (완료 표시)
    const doneTarget = event.target.closest(".todo-check .material-icons:first-child");
    if (doneTarget && listBox.contains(doneTarget)) {
        const todoItem = doneTarget.closest(".todo");
        const todoText = todoItem.querySelector(".todo-text");
        todoText.classList.toggle("done-text");
        return;
    }

    // 삭제 아이콘 클릭 (항목 삭제)
    const deleteTarget = event.target.closest(".todo-check .material-icons:last-child");
    if (deleteTarget && listBox.contains(deleteTarget)) {
        const todoItem = deleteTarget.closest(".todo");
        todoItem.remove();
    }
});

// 새로운 할일 항목 추가 함수
function addTodo(){
    const input = document.querySelector(".input-box>input")
    const inputValue = input.value.trim();
    
    // 입력값이 없으면 경고 표시
    if (inputValue === "") {
        alert("내용을 입력해주세요.");
        return;
    }

    // 할일 항목 구조 생성
    const ul = document.createElement("ul");
    ul.classList.add("todo");

    // 하트 영역
    const likeLi = document.createElement("li");
    likeLi.classList.add("todo-like");

    // 텍스트 영역
    const textLi = document.createElement("li");
    textLi.classList.add("todo-text");

    // 버튼 영역 (체크, 삭제)
    const checkLi = document.createElement("li");
    checkLi.classList.add("todo-check");

    // 빈 하트 아이콘
    const likeIconEmpty = document.createElement("span");
    likeIconEmpty.classList.add("material-icons");
    likeIconEmpty.innerText = "favorite_border";

    // 채운 하트 아이콘
    const likeIconFilled = document.createElement("span");
    likeIconFilled.classList.add("material-icons");
    likeIconFilled.innerText = "favorite";

    // 하트 아이콘 추가
    likeLi.appendChild(likeIconEmpty);
    likeLi.appendChild(likeIconFilled);

    // 입력한 텍스트 추가
    textLi.innerText = inputValue;

    // 체크 아이콘
    const doneIcon = document.createElement("span");
    doneIcon.classList.add("material-icons");
    doneIcon.innerText = "done";

    // 삭제 아이콘
    const deleteIcon = document.createElement("span");
    deleteIcon.classList.add("material-icons");
    deleteIcon.innerText = "delete";

    // 버튼들 추가
    checkLi.appendChild(doneIcon);
    checkLi.appendChild(deleteIcon);    

    // 모든 요소를 하나의 항목에 구성
    ul.appendChild(likeLi);
    ul.appendChild(textLi);
    ul.appendChild(checkLi);

    // 목록에 추가
    listBox.appendChild(ul);
    
    // 입력 필드 초기화
    input.value = "";
}