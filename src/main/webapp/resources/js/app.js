document.addEventListener("DOMContentLoaded", function() {
  // Class FormSelect
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      this.ul = document.createElement("ul");

      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }

  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  // Class FormSteps
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    init() {
      this.events();
      this.updateForm();
    }

    events() {
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    updateForm() {
      this.$step.innerText = this.currentStep;

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;
    }
  }

  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }

  var lastStepButtons = document.getElementsByClassName('lastStep');

  // Dodaj event listener do każdego elementu z klasą "lastStep"
  for (var i = 0; i < lastStepButtons.length; i++) {
    lastStepButtons[i].addEventListener('click', getQuantity);
  }

  function getQuantity() {
    // Pobierz wszystkie pola typu radio z name="institution"
    var radios = document.getElementsByName("institution");
    var selectedValue = null;
    var selectedName = null;

    // Iteracja przez pola radio aby znaleźć zaznaczone
    for (var i = 0; i < radios.length; i++) {
      if (radios[i].checked) {
        selectedValue = radios[i].value;
        selectedName = radios[i].getAttribute('data-name');
        break;
      }
    }

    // Wyświetl nazwę zaznaczonej instytucji w divie
    var institutionOutput = document.getElementById('whatInstitution');
    if (selectedName !== null) {
      institutionOutput.innerHTML = "Instytucja: " + selectedName;
    } else {
      institutionOutput.innerHTML = "Nie wybrano żadnej instytucji.";
    }

    // Pobierz wartość z pola input
    var inputElement = document.getElementById('quantity');
    var quantityValue = inputElement.value;

    // Wyświetl wartość z pola input w divie
    var resultDiv = document.getElementById('quantityOutput');
    resultDiv.innerHTML = "Ilość worków: " + quantityValue;
  }
});